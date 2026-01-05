package org.jusecase.builders.collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jusecase.Builders.a;
import static org.jusecase.Builders.hashSet;
import static org.jusecase.Builders.set;
import static org.jusecase.Builders.sortedSet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;


public class SetBuilderTest {

   @Test
   public void defaultSetImplementation() {
      assertThat(a(set()).getClass()).isEqualTo(HashSet.class);
   }

   @Test
   public void emptySet() {
      assertThat(a(set()).size()).isEqualTo(0);
   }

   @Test
   public void filledSet() {
      assertThat(a(set("a", "b", "c"))).isEqualTo(Set.of("a", "b", "c"));
   }

   @Test
   public void filledSet_duplicatesAreIgnored() {
      assertThat(a(set("a", "b", "c", "c"))).isEqualTo(Set.of("a", "b", "c"));
   }

   @Test
   public void hashSetCanBeBuilt() {
      assertThat(a(hashSet()).getClass()).isEqualTo(HashSet.class);
   }

   @Test
   public void sortedSetCanBeBuilt() {
      assertThat(a(sortedSet()).getClass()).isEqualTo(TreeSet.class);
   }

   @Test
   public void sortedSetCanBeBuilt_string() {
      Set<String> set = a(sortedSet("a", "c", "b"));
      assertThat(set.getClass()).isEqualTo(TreeSet.class);
      assertThat(set).containsExactly("a", "b", "c");
   }
}
