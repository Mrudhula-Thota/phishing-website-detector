public class TestML {

    public static void main(String[] args) {

        String result = MLModel.predict(
                18,
                1,
                0,
                0,
                0,
                0
        );

        System.out.println(result);
    }
}
