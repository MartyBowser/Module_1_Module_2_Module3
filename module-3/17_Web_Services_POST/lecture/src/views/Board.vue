<template>
  <cards-list v-bind:boardId="this.boardId" />
</template>

<script>
import CardsList from '../components/CardsList';

export default {
  components: {
    CardsList
  },
  data() {
    return {
      boardId: 0
    };
  },
  created() {
    this.boardId = parseInt(this.$route.params.id);
    this.$store.commit("SET_ACTIVE_BOARD", this.boardId);
  }
};
</script>
