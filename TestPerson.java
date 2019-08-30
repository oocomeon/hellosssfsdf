package apackage;

public class TestPerson {
    public String getCarInsuranceName(Person person) {
     //   return person.getCar().getInsurance().getName();
    /*    if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";*/
       /* if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();*/
      /* Car car;
       Insurance insurance;
       if ((person != null) && ((car = person.getCar()) != null) && ((insurance = car.getInsurance()) != null)) {
           return insurance.getName();
       }
       return "Unknown";*/
    return null;
    }

    public static void main(String[] args) {

        new TestPerson().getCarInsuranceName(new Person());
    }
}
