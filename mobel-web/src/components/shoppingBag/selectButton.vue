<template>
    <div style="width: 10vw; height: 5vh; display: flex; justify-content: center; align-items: center;">
        <div style="width: 2.5vh; height: 2.5vh; border-radius: 50%; border: 1px solid chocolate;" :style="buttonStyle"
            @click="clickButton"></div>
    </div>
</template>

<script>
import { ref, toRefs } from 'vue';
import { useStore } from 'vuex';

export default {
    name: 'SelectButton',
    props: ['is_select', 'selectMes'],
    emits: ['getSelects'],
    setup(props, context) {
        const store = useStore();
        let buttonStyle = ref({
            backgroundColor: props.is_select ? 'chocolate' : 'white',
        })

        let is_select = toRefs(props).is_select.value;
        let selectMes = toRefs(props).selectMes.value;


        const clickButton = () => {
            if (is_select === false) {
                is_select = true;
                store.commit('updateIsUpdate', true)
                if (selectMes.type === 'goods') {
                    store.commit('addSelectsId', selectMes.data);
                } else if (selectMes.type === 'shop') {
                    for (let i = 0; i < selectMes.data.length; i++) {
                        store.commit('addSelectsId', selectMes.data[i].id);
                    }
                } else if (selectMes.type === 'all') {
                    for (let i = 0; i < selectMes.data.length; i++) {
                        for (let j = 0; j < selectMes.data[i].data.length; j++) {
                            store.commit('addSelectsId', selectMes.data[i].data[j].id);
                        }
                    }
                }
            } else {
                is_select = false;
                if (selectMes.type === 'goods') {
                    store.commit('removeSelectsId', selectMes.data);
                } else if (selectMes.type === 'shop') {
                    for (let i = 0; i < selectMes.data.length; i++) {
                        store.commit('removeSelectsId', selectMes.data[i].id);
                    }
                } else if (selectMes.type === 'all') {
                    for (let i = 0; i < selectMes.data.length; i++) {
                        for (let j = 0; j < selectMes.data[i].data.length; j++) {
                            store.commit('removeSelectsId', selectMes.data[i].data[j].id);
                        }
                    }
                }
            }
            buttonStyle.value.backgroundColor = is_select ? 'chocolate' : 'white';
            while (store.state.shoppingbag.is_update) { true; }
            context.emit('getSelects');
            // store.commit('updateIsUpdate', false);
        }
        return {
            buttonStyle,
            clickButton
        }
    }
}

</script>

<style scoped>

</style>