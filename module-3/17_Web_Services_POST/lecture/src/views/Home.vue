<template>
  <div></div>
</template>

<script>
export default {
  created() {
    // if there are boards, forward to first board/card list
    if (this.$store.state.boards.length > 0) {
      const firstBoard = this.$store.state.boards[0];
      this.$router.push({ name: 'Board', params: { id : firstBoard.id }})
    }
  }
};
</script>
