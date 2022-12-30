<template>
  <div id="app">
    <NavBar />
    <router-view />
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue';
export default {
  name: 'APP',
  components: {
    NavBar
  }
}
</script>

<style>
/* @font-face {
  font-family: 'fangZhengHei';
  src: url('@/assets/ttf/FZLTHJW.TTF');
}

* {
  font-family: 'fangZhengHei';
} */
* {
  box-sizing: border-box;
}
</style>
