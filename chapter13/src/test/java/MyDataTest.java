import org.example.MyData;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyDataMap 단위 테스트")
class MyDataTest {

    private MyData<String, String> map;

    @BeforeEach // 각 테스트 메소드 실행 전에 실행됨
    void setUp() {
        map = new MyData<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
    }

    @Test
    @DisplayName("m1 & m2: 데이터 추가 및 조회 테스트")
    void testPutAndGet() {
        map.put("key3", "value3");
        assertEquals("value3", map.get("key3"), "새로운 데이터가 올바르게 추가되어야 함");

        map.put("key1", "newValue");
        assertEquals("newValue", map.get("key1"), "기존 키가 있으면 값이 수정되어야 함");
    }

    @Test
    @DisplayName("m3: 데이터 삭제 테스트")
    void testRemove() {
        boolean isRemoved = map.remove("key1");
        assertTrue(isRemoved, "삭제 성공 시 true 리턴");
        assertNull(map.get("key1"), "삭제된 키로 조회 시 null 리턴");
    }

    @Test
    @DisplayName("m4: 데이터 개수 테스트")
    void testSize() {
        assertEquals(2, map.size());
        map.put("key3", "value3");
        assertEquals(3, map.size());
    }

    @Test
    @DisplayName("m5: 두 키의 값 교환 테스트")
    void testChange() {
        // 교환 전 확인
        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));

        // 교환 실행
        map.change("key1", "key2");

        // 교환 후 확인 (값이 서로 바뀌었는지 검증)
        assertEquals("value2", map.get("key1"), "key1의 값은 원래 key2의 값이어야 함");
        assertEquals("value1", map.get("key2"), "key2의 값은 원래 key1의 값이어야 함");
    }
}
