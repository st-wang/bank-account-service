package ddd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainEntityTest {

    @Test
    public void should_compute_id_if_the_given_one_is_null() {
        // Given
        DomainEntity entity = new DomainEntity(null);
        // When
        String id = entity.getId();
        // Then
        assertThat(id).isNotNull();
    }

    @Test
    public void should_compute_id_if_the_given_one_is_empty() {
        // Given
        String originalId = "";
        DomainEntity entity = new DomainEntity(originalId);
        // When
        String id = entity.getId();
        // Then
        assertThat(id).isNotNull().isNotEqualTo(originalId);
    }

    @Test
    public void should_compute_id_if_the_given_one_is_blank() {
        // Given
        String originalId = "      ";
        DomainEntity entity = new DomainEntity(originalId);
        // When
        String id = entity.getId();
        // Then
        assertThat(id).isNotNull().isNotEqualTo(originalId);
    }

    @Test
    public void should_return_the_given_id_if_not_null() {
        // Given
        String originalId = "originalId";
        DomainEntity entity = new DomainEntity(originalId);

        // When
        String id = entity.getId();
        // Then
        assertThat(id).isEqualTo(originalId);
    }

    @Test
    public void should_compute_unique_id() {
        // Given
        DomainEntity entity = new DomainEntity(null);
        DomainEntity entity2 = new DomainEntity(null);
        // Then
        assertThat(entity.getId()).isNotEqualTo(entity2.getId());
    }

    @Test
    public void should_satisfy_Entity_equality() {
        // Given
        String originalId = "originalId";
        DomainEntity entity = new DomainEntity(originalId);
        DomainEntity entity2 = new DomainEntity(originalId);
        // Then
        assertThat(entity).isEqualTo(entity2);
    }

    @Test
    public void should_not_be_equal_to_another_entity_having_a_different_id() {
        // Given
        DomainEntity entity = new DomainEntity("originalId");
        DomainEntity entity2 = new DomainEntity(null);
        // Then
        assertThat(entity).isNotEqualTo(entity2);
    }

    @Test
    public void should_satisfy_Entity_hashcode() {
        // Given
        String originalId = "originalId";
        DomainEntity entity = new DomainEntity(originalId);
        DomainEntity entity2 = new DomainEntity(originalId);
        // Then
        assertThat(entity.hashCode()).isEqualTo(entity2.hashCode());
    }

    @Test
    public void should_not_have_the_same_hashcode_than_another_entity_having_a_different_id() {
        // Given
        DomainEntity entity = new DomainEntity("originalId");
        DomainEntity entity2 = new DomainEntity(null);
        // Then
        assertThat(entity.hashCode()).isNotEqualTo(entity2.hashCode());
    }

}