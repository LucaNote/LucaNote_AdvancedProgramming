package be.vives.ti.priorityqueue;

import be.vives.ti.adt.PriorityQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayPriorityQueueTest {

    private PriorityQueue<Integer> priorityQueue;

    @BeforeEach
    void setUp() {
        priorityQueue = new ArrayPriorityQueue(10);
    }

    @Test
    void testArrayPriorityQueueImplementation() {
        assertThat(priorityQueue.isEmpty()).isTrue();

        priorityQueue.insert(100);
        assertThat(priorityQueue.isEmpty()).isFalse();
        assertThat(priorityQueue.size()).isEqualTo(1);

        assertThat(priorityQueue.min()).isEqualTo(100);
        assertThat(priorityQueue.isEmpty()).isFalse();
        assertThat(priorityQueue.size()).isEqualTo(1);

        priorityQueue.insert(50);
        priorityQueue.insert(30);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(80);

        assertThat(priorityQueue.isEmpty()).isFalse();
        assertThat(priorityQueue.size()).isEqualTo(6);
        assertThat(priorityQueue.min()).isEqualTo(10);

        assertThat(priorityQueue.removeMin()).isEqualTo(10);
        assertThat(priorityQueue.size()).isEqualTo(5);


        assertThat(priorityQueue.removeMin()).isEqualTo(30);
        assertThat(priorityQueue.size()).isEqualTo(4);

        assertThat(priorityQueue.removeMin()).isEqualTo(40);
        assertThat(priorityQueue.size()).isEqualTo(3);

        assertThat(priorityQueue.removeMin()).isEqualTo(50);
        assertThat(priorityQueue.size()).isEqualTo(2);

        assertThat(priorityQueue.removeMin()).isEqualTo(80);
        assertThat(priorityQueue.size()).isEqualTo(1);

        assertThat(priorityQueue.removeMin()).isEqualTo(100);
        assertThat(priorityQueue.size()).isEqualTo(0);

        assertThat(priorityQueue.isEmpty()).isTrue();

    }

    @Test
    void tooMuchElementsInPriorityQueue() {
        PriorityQueue<Integer> beperkteQueue = new ArrayPriorityQueue(5);
        beperkteQueue.insert(1);
        beperkteQueue.insert(2);
        beperkteQueue.insert(3);
        beperkteQueue.insert(3);
        beperkteQueue.insert(9);
        assertThrows(IllegalStateException.class,
                ()-> beperkteQueue.insert(14));
    }
}