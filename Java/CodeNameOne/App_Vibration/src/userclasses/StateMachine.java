package userclasses;

import com.codename1.io.Log;
import generated.StateMachineBase;
import com.codename1.ui.*;
import com.codename1.ui.events.*;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Riccardo Landolfo
 */
public class StateMachine extends StateMachineBase {
    
    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    /**
     * this method should be used to initialize variables instead of the
     * constructor/class scope to avoid race conditions
     */
    protected void initVars(Resources res) {
    }
    
    @Override
    protected void onMain_BtnVibrateAction(Component c, ActionEvent event) {
        
        Display.getInstance().vibrate(100);
        
        findLbVibrate().setText(findLbVibrate().getText() + "Vibration\n");
   
    }
}
