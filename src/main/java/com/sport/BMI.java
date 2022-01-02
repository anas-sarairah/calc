package com.sport;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BMI {

    @RequestMapping(value = "/bmi", method = RequestMethod.POST)
    public String findBmi(@ModelAttribute BmiInput bmiInput){

        System.out.println("inside controller");
        System.out.println(bmiInput.getGender());
        System.out.println(bmiInput.getAge());
        System.out.println(bmiInput.getHeight());
        System.out.println(bmiInput.getWeight());
        System.out.println(bmiInput.getStatus());

bmiInput.setBmi(bmiInput.getWeight()/(bmiInput.getHeight() * bmiInput.getHeight()));
if(bmiInput.getGender().toString().equalsIgnoreCase("male")){
    bmiInput.setBmr((66 + (6.2 * bmiInput.getWeight()) + (12.7 * (bmiInput.getHeight() * 100))) - (6.76 * bmiInput.getAge()));
}else{
    bmiInput.setBmr((665.1 + (4.35 * bmiInput.getWeight()) + (4.7 * (bmiInput.getHeight() * 100))) - (4.7 * bmiInput.getAge()));
}

if(bmiInput.getStatus().toString().equalsIgnoreCase(Status.inactive.toString())){
bmiInput.setBmr2(bmiInput.getBmr() * ActivityLevel.inactive);

}else if (bmiInput.getStatus().toString().equalsIgnoreCase(Status.slack.toString())){
    bmiInput.setBmr2(bmiInput.getBmr() * ActivityLevel.slack);

}else if (bmiInput.getStatus().toString().equalsIgnoreCase(Status.semiActive.toString())){
    bmiInput.setBmr2(bmiInput.getBmr() * ActivityLevel.semiActive);

}else if (bmiInput.getStatus().toString().equalsIgnoreCase(Status.veryActive.toString())){
    bmiInput.setBmr2(bmiInput.getBmr() * ActivityLevel.veryActive);

}else if (bmiInput.getStatus().toString().equalsIgnoreCase(Status.extremelyActive.toString())){
    bmiInput.setBmr2(bmiInput.getBmr() * ActivityLevel.extremelyActive);
}

if(bmiInput.getBmi()>= 16 && bmiInput.getBmi()<18.5){
    bmiInput.setBmiIndicatorMessage("Under Weight");

}else if(bmiInput.getBmi()>= 18.5 && bmiInput.getBmi()<= 24.9){
    bmiInput.setBmiIndicatorMessage("Normal Weight");

} else if(bmiInput.getBmi()> 24.9 && bmiInput.getBmi()<= 29.9){
    bmiInput.setBmiIndicatorMessage("Over Weight");

}else if(bmiInput.getBmi()> 29.9 && bmiInput.getBmi()<= 34.9){
    bmiInput.setBmiIndicatorMessage("Fat Level One");


}else if(bmiInput.getBmi()> 34.9 && bmiInput.getBmi()<= 39.9){
    bmiInput.setBmiIndicatorMessage("Fat Level Two");

}else if(bmiInput.getBmi()>= 40){
    bmiInput.setBmiIndicatorMessage("Fat Level Three");

}
        bmiInput.setShow("");
        bmiInput.setResult("Results !!");

        return "bmi" ;
    }

    @RequestMapping(value = "/bmi",method = RequestMethod.GET)
    public String bmi(@ModelAttribute BmiInput bmiInput) {
        bmiInput.setShow("hidden");
        return "bmi";
    }

    @RequestMapping(value = "/normal",method = RequestMethod.GET)
    public String normal(@ModelAttribute BmiInput bmiInput) {

        return "normal";
    }

    @RequestMapping(value = "/aerobic",method = RequestMethod.GET)
    public String aerobic(@ModelAttribute BmiInput bmiInput) {

        return "aerobic";
    }

    @RequestMapping(value = "/keto",method = RequestMethod.GET)
    public String keto(@ModelAttribute BmiInput bmiInput) {

        return "keto";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String bmi() {
        return "home";
    }


}
