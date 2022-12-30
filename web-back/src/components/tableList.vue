<template>
    <div class="pageList">
        <div class="all">共{{ allLen }}条</div>
        <form>
            每页
            <select v-model="index">
                <option>3</option>
                <option>10</option>
                <option>20</option>
                <option>50</option>
            </select>
            条
            <button type="button" @click="setIndex(index)">确定</button>
        </form>
        <div style="display: flex;">
            <button v-if="(parseInt(allLen / index + 0.99) >= 1)" @click="setPage(1)">1</button>
            <button v-if="(parseInt(allLen / index + 0.99) >= 3)" @click="setPage(2)">2</button>
            <button v-if="(parseInt(allLen / index + 0.99) >= 5)" @click="setPage(3)">3</button>
            <div style="display: flex;" v-if="(parseInt(allLen / index + 0.99) > 6)">
                <div v-if="((page - 1) > 4)">...</div>
                <button v-if="(((page - 1) > 3) && page < parseInt(allLen / index + 0.99) - 1)"
                    @click="setPage(page - 1)">
                    {{ (page - 1) }}
                </button>
                <button v-if="((page > 3) && page < parseInt(allLen / index + 0.99) - 2)" @click="setPage(page)">{{
                        page
                }}</button>
                <button v-if="((page + 1) < parseInt(allLen / index + 0.99) - 2 && page > 2)"
                    @click="setPage(page + 1)">
                    {{ (page + 1) }}
                </button>
                <div v-if="((page + 1) < parseInt(allLen / index + 0.99) - 3)">...</div>
            </div>
            <button v-if="(parseInt(allLen / index + 0.99) >= 6)" @click="setPage(parseInt(allLen / index + 0.99) - 2)">
                {{ (parseInt(allLen / index + 0.99) - 2) }}
            </button>
            <button v-if="(parseInt(allLen / index + 0.99) >= 4)" @click="setPage(parseInt(allLen / index + 0.99) - 1)">
                {{ (parseInt(allLen / index + 0.99) - 1)
                }}</button>
            <button v-if="(parseInt(allLen / index + 0.99) >= 2)" @click="setPage(parseInt(allLen / index + 0.99))">
                {{ (parseInt(allLen / index + 0.99)) }}</button>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue';

export default {
    name: 'TableList',
    emits: ['setIndex', 'setPage'],
    props: ['page', 'allLen'],
    setup(_, context) {
        let index = ref(3)

        const setIndex = (i) => {
            index.value = i;
            context.emit('setIndex', i)
        }

        const setPage = (i) => {
            context.emit('setPage', i)
        }
        return {
            index,
            setIndex,
            setPage
        }
    }
}

</script>

<style scoped>
.pageList {
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 15px;
    color: white;
}

.pageList button {
    background-color: darkcyan;
    border: 0;
    color: white;
    margin-right: 8px;
}

.pageList>div {
    margin-right: 15px;
}
</style>