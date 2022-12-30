<template>
    <HomeBody>
        <ShopTop />
        <ShopBody />
        <!-- <ShopBottum /> -->
    </HomeBody>
</template>

<script>
import HomeBody from '@/components/homeBody.vue';
import { useStore } from 'vuex';
// import { ref } from 'vue';
import ShopTop from '@/components/shoppingBag/shopTop.vue';
import ShopBody from '@/components/shoppingBag/shopBody.vue';
// import ShopBottum from '@/components/shoppingBag/shopBottum.vue';

export default {
    name: "ShoppingBag",
    setup() {
        const store = useStore();
        store.commit("updateIsHome", true);

        return {
        };
    },
    components: { HomeBody, ShopTop, ShopBody }
}

</script>

<style scoped>

</style>