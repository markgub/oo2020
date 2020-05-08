package app;

import java.util.ArrayList;
import java.util.List;

public class MatterClassArray implements Matter{
    public double mMass;
    public String mName = "";

    public MatterClassArray(IonClass[] ions) {
        int mCharge = 0;
        double potentialMass = 0;
        List<String> fullName = new ArrayList<>();
        boolean copy;
        /*fullName.add("0");
        fullName.add("0");*/
        for(int i = 0; i < ions.length; i ++){
            copy = false;
            mCharge += ions[i].getCharge();
            potentialMass += ions[i].getAMass();
            for(int j = 0; j < fullName.size(); j ++){
                if(fullName.get(j) == ions[i].getName()){
                    int newNr = Integer.parseInt(fullName.get(j+1)) + 1;
                    if(newNr == 1) newNr++;
                    fullName.set(j+1, Integer.toString(newNr));
                    copy = true;
                    break;
                }
            }
            if(!copy){
                if(ions[i].getCharge() > 0){
                    fullName.add(0, ions[i].getName());
                    fullName.add(1, "0");
                } else {
                    fullName.add(ions[i].getName());
                    fullName.add("0");
                }
            }
        }
        if(mCharge == 0){
            mMass = potentialMass;
            /*System.out.println(fullName);*/
            for(String name: fullName){
                if(name != "0"){
                    mName += name;
                }
            }
        } else {
            mName = "Antud ioonide kokkupanemine ei ole lubatud!";
            mMass = 0;
        }
    }

    @Override
    public double getMass() {
        // TODO Auto-generated method stub
        return mMass;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return mName;
    }
}