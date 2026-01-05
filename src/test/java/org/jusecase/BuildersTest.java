package org.jusecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.an;
import static org.jusecase.Builders.of;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.jusecase.builders.Builder;


public class BuildersTest implements Builder<String> {

   private boolean buildHasBeenCalled;

   @Override
   public String build() {
      this.buildHasBeenCalled = true;
      return "";
   }

   @BeforeEach
   public void setUp() {
      this.buildHasBeenCalled = false;
   }

   @Test
   public void testAIsCallingBuild() {
      a(this);
      assertThat(this.buildHasBeenCalled).isTrue();
   }

   @Test
   public void testAnIsCallingBuild() {
      an(this);
      assertThat(this.buildHasBeenCalled).isTrue();
   }

   @Test
   public void testOfArrayReturnsInput() {
      final String[] input = new String[] { "input" };
      final String[] output = of(input);
      assertThat(output).isEqualTo(input);
   }

   @Test
   public void testOfReturnsInput() {
      final String input = "input";
      final String output = of(input);
      assertThat(output).isEqualTo(input);
   }
}
