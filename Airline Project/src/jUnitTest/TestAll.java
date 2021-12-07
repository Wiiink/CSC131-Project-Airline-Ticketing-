package jUnitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AirplaneTest.class, UtilTest.class, SeatTest.class, UITest.class, SeatButtonTest.class, TrackerTest.class, FlightSelectTest.class, eventAndObserverTest.class})
public class TestAll {
}
