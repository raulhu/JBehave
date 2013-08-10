package com.storm.jbehave;

import java.util.*;


import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.storm.jbehave.CalcAddSteps;
import org.junit.Test;

public class CalcStory extends JUnitStory {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
// where to find the stories
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
// TXT reporting
                .useStoryReporterBuilder(
                        new StoryReporterBuilder().withDefaultFormats()
                                .withFormats(Format.HTML,Format.TXT,Format.XML));

    }

    // Here we specify the steps classes
    @Override
    public List<CandidateSteps> candidateSteps() {
// varargs, can have more that one steps classes

       return  new InstanceStepsFactory(configuration(), new CalcAddSteps())
                .createCandidateSteps();
    }

    @Override
    @Test
    public void run(){
        try{
            super.run();
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
}
