<template>
  <router-view />
  <Footer v-if="$store.state.page.is_home" />
</template>

<script>
import Footer from './components/footer.vue';

export default {
  components: { Footer }
}
</script>

<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
}
</style>
