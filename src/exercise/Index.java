package exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Index {

    public Map indexing(String source) {
        Map<String, HashSet> map = new TreeMap<String, HashSet>();
        List<String> tokens = Arrays.asList(Pattern.compile(" ").split(source));

        // if there are only two words, we are done!
        if (tokens.size() == 2) {
            map.put(source, new HashSet());
            return map;
        }

        String first = tokens.get(0);
        String second = tokens.get(1);

        for (int i = 2; i <= tokens.size(); i++) {
            String next;

            // reaching the end of the source
            if (i == tokens.size()) {
                next = null;
            } else {
                next = tokens.get(i);
            }

            String pairToSearch = first + " " + second;
            HashSet<String> listOfSuccessors = map.get(pairToSearch);

            if (listOfSuccessors == null) {
                listOfSuccessors = new HashSet<String>();
            }

            if(listOfSuccessors.size() == 0) {  //it has not been added to the map, so add it
                if (next != null) { // obviously make no sense if adding 'null' element
                    listOfSuccessors.add(next);
                }
                map.put(pairToSearch, listOfSuccessors);
            } else {
                // if reaching the end of the source, don't add the null element to the list
                if (next == null) {
                    continue;
                }
                listOfSuccessors.add(next);
            }
            first = second;
            second = next;
        }
        return map;
    }
}
