package chakman.putt.state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

public class StatePatternEg_Phone_Udemy {
}

enum State {
	OFF_HOOK,   // starting state
	ON_HOOK,	// terminal state
	CONNECTING,
	CONNECTED,
	ON_HOLD
}

enum Trigger {
	CALL_DIALED,
	HUNG_UP,
	CALL_CONNECTED,
	PLACED_ON_HOLD,
	TAKEN_OFF_HOLD,
	LEFT_MESSAGE,
	STOP_USING_PHONE
}

class Demo {
	private static Map<State, List<Pair<Trigger, State>>> rules = 
			new HashMap<>();
	
}