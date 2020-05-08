package app;

public class MatterClass implements Matter{

    public double mMass;
    public String mName;

    public MatterClass(IonClass ion1, IonClass ion2) {
        if(ion1.getCharge() + ion2.getCharge() == 0){
            mMass = ion1.getAMass() + ion2.getAMass();
            if(ion1.getCharge() > ion2.getCharge()){
                mName = ion1.getName() + ion2.getName();
            } else {
                mName = ion2.getName() + ion1.getName();
            }
        } else {
            System.out.println("Antud ioonide kokkupanemine ei ole lubatud!");
            mName = "Puudub";
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