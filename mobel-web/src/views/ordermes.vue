<template>
    {{ orderMes }}
</template>

<script>
import $ from 'jquery';
import { ref } from 'vue';
import { useStore } from 'vuex';

export default {
    name: 'OrderMes',
    setup() {
        const store = useStore();
        let orderMes = ref([]);
        $.ajax({
            url: 'http://localhost:3000/query/order/id',
            type: 'get',
            headers: {
                Authorization: "Bearer " + store.state.user.token,
            },
            data: {
                id: store.state.order.orderId,
            },
            success: resp => {
                orderMes.value = resp;
            }
        })
        return {
            orderMes
        }
    }
}

</script>

<style scoped>

</style>