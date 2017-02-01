
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ModelTest.class,
	ControllerTest.class,
	HotelDAOTests.class,
	UserDAOTests.class,
	RoomDAOTests.class
})
public class AllTests {

}