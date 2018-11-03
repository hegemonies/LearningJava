package PhoneBook;
import CSV.*;

abstract class User implements CSV {
    private String SNP; // ФИО
    private String phone;

    public User(String SNP, String phone) {
        setSNP(SNP);
        setPhone(phone);
    }

    public String getSNP() {
        return SNP;
    }

    public void setSNP(String SNP) {
        this.SNP = SNP;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String toString() {
        return getSNP() + " " + getPhone();
    }

//    public String toCSV(Object obj) {
//        if (obj.getClass().getName().equals("Entity")) {
//            Entity entity = (Entity) obj;
//            return entity.getSNP() +
//                    entity.getPhone() +
//                    entity.getTIN();
//        } else if (obj.getClass().getName().equals("Individual")) {
//            Individual individual = (Individual) obj;
//            return individual.getSNP() +
//                    individual.getPhone() +
//                    individual.get();
//        }
//    }
}
