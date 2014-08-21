package com.slize.softsynth;

import com.slize.softsynth.Engien.Output;
import com.slize.softsynth.Modules.Attenuator;
import com.slize.softsynth.Modules.Oscillator;

public class Softsynth {

    public static void main(String[] args) throws Exception {
        Thread output = new Thread(new Output(), "output");

        Oscillator osc1 = new Oscillator();

        Attenuator attenuator = new Attenuator();

        output.start();

        // Set what module has the output.
        Output.setSampleProvider(attenuator);

        attenuator.setSampleProvider(osc1);

        while(true) {
            attenuator.setAttenuationRatio(0.1);
            Thread.sleep(1000);
            attenuator.setAttenuationRatio(1.0);
            Thread.sleep(1000);
        }
    }
}
