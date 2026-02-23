package designpatterns;

/**
 * Builder Pattern implementation.
 * Separates object construction from representation, allowing step-by-step
 * creation.
 */
class User {
    // Required fields
    private final String name;

    // Optional fields
    private final int age;
    private final String phone;
    private final String address;

    // Private constructor enforcing creation through Builder
    private User(UserBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Static inner Builder class
    public static class UserBuilder {
        private final String name; // Required
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String name) {
            this.name = name;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this; // Return builder instance
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this; // Return builder instance
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this; // Return builder instance
        }

        public User build() {
            return new User(this); // Create user using current builder context
        }
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        System.out.println("Testing Builder Pattern...\n");

        // Construct User step-by-step
        User user1 = new User.UserBuilder("Alice")
                .age(25)
                .phone("123-456-7890")
                .address("123 Main St, New York")
                .build();

        // Construct another User omitting optional parameters
        User user2 = new User.UserBuilder("Bob")
                .age(30)
                .build();

        System.out.println("User 1: " + user1);
        System.out.println("User 2: " + user2);
    }
}
