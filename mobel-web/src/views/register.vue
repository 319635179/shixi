<template>
    <div>222</div>
</template>

<script>
import { useStore } from 'vuex';


export default {
    name: 'RegisterView',
    setup() {
        const store = useStore();

        store.commit('updateIsHome', true);
        return {

        }
    }
}

</script>

<style scoped>

</style>