package runner;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import tests_engineers.BaseEngineerTests;
import tests_engineers.ExecuteTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({BaseEngineerTests.class, ExecuteTests.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnit4Runner {

}
