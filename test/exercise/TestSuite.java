package exercise;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        SourceTest.class,
        exercise.IndexTest.class,
        exercise.RandomTextGeneratorTest.class
})

public class TestSuite {
}
