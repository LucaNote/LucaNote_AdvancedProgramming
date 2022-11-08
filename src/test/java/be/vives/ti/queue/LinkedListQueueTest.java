package be.vives.ti.queue;

import be.vives.ti.adt.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListQueueTest {

    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new LinkedListQueue();
    }

    @Test
    void testLinkedListQueueImplementation() {
        assertThat(queue.size()).isEqualTo(0);
        assertThat(queue.isEmpty()).isTrue();

        assertThat(queue.first()).isNull();
        assertThat(queue.dequeue()).isNull();

        queue.enqueue("one");
        assertThat(queue.size()).isEqualTo(1);
        assertThat(queue.isEmpty()).isFalse();

        queue.enqueue("two");
        queue.enqueue("three");
        queue.enqueue("four");
        assertThat(queue.size()).isEqualTo(4);

        assertThat(queue.first()).isEqualTo("one");
        assertThat(queue.size()).isEqualTo(4);

        assertThat(queue.dequeue()).isEqualTo("one");
        assertThat(queue.first()).isEqualTo("two");
        assertThat(queue.size()).isEqualTo(3);

        assertThat(queue.dequeue()).isEqualTo("two");
        assertThat(queue.first()).isEqualTo("three");
        assertThat(queue.size()).isEqualTo(2);

        queue.enqueue("five");
        queue.enqueue("six");
        queue.enqueue("seven");

        assertThat(queue.size()).isEqualTo(5);
        assertThat(queue.first()).isEqualTo("three");

        assertThat(queue.dequeue()).isEqualTo("three");
        queue.enqueue("eight");
        assertThat(queue.size()).isEqualTo(5);

        assertThat(queue.dequeue()).isEqualTo("four");
        queue.enqueue("nine");
        assertThat(queue.size()).isEqualTo(5);
        assertThat(queue.first()).isEqualTo("five");
    }

}
