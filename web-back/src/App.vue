<template>
  <Navbar />
  <router-view />
</template>

<script>
import Navbar from './components/Navbar.vue';
export default {
  name: "App",
  components: {
    Navbar
  }
}
</script>

<style>
* {
  box-sizing: border-box;
}

body {
  min-width: 1440px;
}
</style>
