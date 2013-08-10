package com.storm.jbehave;


import junit.framework.Assert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


// Scenario ...
//Given x is equal to 10 or y is equal to 10 or c is equal to 0
//When I add x equal to 10 with y equal to 10
//Then c is equal to 20

public class CalcAddSteps{
    int x, y, c;

    //Scenario 1
    @Given("x is equal to $valueX or y is equal to $valueY or c is equal to $valueC")
    public void givenValue(@Named("valueX") int valueX, @Named("valueY") int valueY, @Named("valueC") int valueC){
        x = valueX;
        y = valueY;
        c = valueC;
    }

    @When("I add x equal to 10 with y equal to 10")
    public void whenIAddXWithY(){
        c = x + y;
    }



    @Then("c is equal to $valueC")
    public void thenCequalTo(@Named("valueC") int valueC){
        Assert.assertEquals(valueC, c);
        //if(valueC != c)
          //  throw new RuntimeException("C is " + c + ", but should be " + valueC);

    }

    //Scenario 2
   // @Given("c is $valueC")
   // public void s2givenValue(@Named("valueC") int valueC){
   //     c = valueC;
   // }

    @When("I sub $value from c")
    public void s2WhenISubValueFromC(int value){
        c = c - value;
    }

    @Then("c should be $valueC")
    public void s2ThenCequalTo(int valueC){
        Assert.assertEquals(valueC, c);
    }
}
