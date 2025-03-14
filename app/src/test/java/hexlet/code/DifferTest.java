package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testGenerateDiffWhenFilesAreEqual() throws Exception {
        String path1 = "./src/test/resources/test1.json";
        String path2 = "./src/test/resources/test2.json";

        String expected = "{\n" + "    host: hexlet.io\n" + "    timeout: 20\n" + "    verbose: true\n" + "}";
        String diff = Differ.generate(path1, path2);

        assertEquals(expected, diff);
    }

    @Test
    void testGenerateDiffWhenFilesAreNotEqual() throws Exception {
        String path1 = "./src/test/resources/test3.json";
        String path2 = "./src/test/resources/test4.json";

        String expected = "{\n" + "    host: hexlet.io\n" + "  + timeout: 20\n" + "    verbose: true\n" + "}";
        String diff = Differ.generate(path1, path2);

        assertEquals(expected, diff);


    }
    @Test
    void testGenerateDiffWhenFilesAreOneEmpty() throws Exception {
        String path1 = "./src/test/resources/test5.json";
        String path2 = "./src/test/resources/test6.json";

        String expected = "{\n" + "  + host: hexlet.io\n" + "  + timeout: 20\n" + "  + verbose: true\n" + "}";
        String diff = Differ.generate(path1, path2);

        assertEquals(expected, diff);


    }
    @Test
    void testGenerateDiffWhenFilesAreAllEmpty() throws Exception {
        String path1 = "./src/test/resources/test5.json";
        String path2 = "./src/test/resources/test8.json";

        String expected = "{\n" + "}";
        String diff = Differ.generate(path1, path2);

        assertEquals(expected, diff);
    }
    @Test
    void testGenerateDiffWhenFilesAreAnotherEmpty() throws Exception {
        String path1 = "./src/test/resources/test6.json";
        String path2 = "./src/test/resources/test5.json";

        String expected = "{\n" + "  - host: hexlet.io\n" + "  - timeout: 20\n" + "  - verbose: true\n" + "}";
        String diff = Differ.generate(path1, path2);

        assertEquals(expected, diff);


    }
    @Test
    void testGenerateDiffWhenFilesHaveDifferentValues() throws Exception {
        String path1 = "./src/test/resources/test9.json";
        String path2 = "./src/test/resources/test10.json";

        String expected = "{\n" + "    host: hexlet.io\n" + "  - timeout: 20\n" + "  + timeout: 30\n" + "}";
        String diff = Differ.generate(path1, path2);

        assertEquals(expected, diff);
    }

    @Test
    void testGenerateDiffWhenFilesHaveDifferentKeys() throws Exception {
        String path1 = "./src/test/resources/test11.json";
        String path2 = "./src/test/resources/test12.json";


        String expected = "{\n" + "    host: hexlet.io\n" + "  - timeout: 20\n" + "  + verbose: true\n" + "}";
        String diff = Differ.generate(path1, path2);

        assertEquals(expected, diff);
    }

        @Test
        void testYamlSpecificFeatures() throws Exception {
            String path1 = "./src/test/resources/test1.yml";
            String path2 = "./src/test/resources/test2.yml";

            String expected = """
            {
              - follow: false
                host: hexlet.io
              - proxy: 123.234.53.22
              - timeout: 50
              + timeout: 20
              + verbose: true
            }""";

            String diff = Differ.generate(path1, path2);

            assertEquals(expected, diff);
        }

    @Test
    void testYamlBothAreEquals() throws Exception {
        String path1 = "./src/test/resources/test3.yml";
        String path2 = "./src/test/resources/test4.yml";

        String expected = """
            {
                host: hexlet.io
                timeout: 20,
                verbose: true,
            }""";

        String diff = Differ.generate(path1, path2);

        assertEquals(expected, diff);
    }

    @Test
    void testGenerateDiffWhenFilesAreWithBigStruct() throws Exception {
        String path1 = "./src/test/resources/file1big.json";
        String path2 = "./src/test/resources/file2big.json";

        String expected = """
            {
                chars1: [a, b, c]
              - chars2: [d, e, f]
              + chars2: false
              - checked: false
              + checked: true
              - default: null
              + default: [value1, value2]
              - id: 45
              + id: null
              - key1: value1
              + key2: value2
                numbers1: [1, 2, 3, 4]
              - numbers2: [2, 3, 4, 5]
              + numbers2: [22, 33, 44, 55]
              - numbers3: [3, 4, 5]
              + numbers4: [4, 5, 6]
              + obj1: {nestedKey=value, isNested=true}
              - setting1: Some value
              + setting1: Another value
              - setting2: 200
              + setting2: 300
              - setting3: true
              + setting3: none
            }""";
        String diff = Differ.generate(path1, path2);

        assertEquals(expected, diff);
    }

    @Test
    void testGenerateDiffWhenFilesAreWithBigStructYAML() throws Exception {
        String path1 = "./src/test/resources/file1big.yml";
        String path2 = "./src/test/resources/file2big.yml";

        String expected = """
            {
                chars1: [a, b, c]
              - chars2: [d, e, f]
              + chars2: false
              - checked: false
              + checked: true
              - default: null
              + default: [value1, value2]
              - id: 45
              + id: null
              - key1: value1
              + key2: value2
                numbers1: [1, 2, 3, 4]
              - numbers2: [2, 3, 4, 5]
              + numbers2: [22, 33, 44, 55]
              - numbers3: [3, 4, 5]
              + numbers4: [4, 5, 6]
              + obj1: {nestedKey=value, isNested=true}
              - setting1: Some value
              + setting1: Another value
              - setting2: 200
              + setting2: 300
              - setting3: true
              + setting3: none
            }""";
        String diff = Differ.generate(path1, path2);

        assertEquals(expected, diff);
    }



}
