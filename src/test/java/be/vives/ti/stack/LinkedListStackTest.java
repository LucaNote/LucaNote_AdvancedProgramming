package be.vives.ti.stack;

import be.vives.ti.adt.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListStackTest {

    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new LinkedListStack();
    }

    @Test
    void testLinkedListStackImplementatie() {
        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.peek()).isNull();
        assertThat(stack.pop()).isNull();

        stack.push("one");
        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.size()).isEqualTo(1);

        stack.push("two");
        stack.push("three");
        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.size()).isEqualTo(3);

        assertThat(stack.peek()).isEqualTo("three");
        assertThat(stack.size()).isEqualTo(3);

        assertThat(stack.pop()).isEqualTo("three");
        assertThat(stack.size()).isEqualTo(2);

        assertThat(stack.pop()).isEqualTo("two");
        assertThat(stack.pop()).isEqualTo("one");
        assertThat(stack.size()).isEqualTo(0);
        assertThat(stack.isEmpty()).isTrue();
    }


}