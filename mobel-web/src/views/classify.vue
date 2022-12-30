<template>
    <HomeBody></HomeBody>
</template>

<script>
import HomeBody from '@/components/homeBody.vue';
import { useStore } from 'vuex';

export default {
    name: "ClassifyView",
    setup() {
        const store = useStore();
        store.commit("updateIsHome", true);
        return {};
    },
    components: { HomeBody }
}

</script>

<style scoped>

</style>