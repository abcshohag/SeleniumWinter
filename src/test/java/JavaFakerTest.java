import com.github.javafaker.Faker;

public class JavaFakerTest {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.gameOfThrones().quote());
    }
}
