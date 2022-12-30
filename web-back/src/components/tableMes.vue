<template>
    <div class="userTable">
        <div class="table">
            <div class="title" v-for="(title) in tableTitle"
                :style="{ ...title.style, backgroundColor: 'rgb(44, 108, 160)', borderTop: '1px solid rgb(236, 206, 36)' }"
                :key="title.id">{{ title.name }}
            </div>
            <div class="title"
                :style="{ width: '150px', backgroundColor: 'rgb(44, 108, 160)', borderTop: '1px solid rgb(236, 206, 36)' }">
                操作</div>
        </div>
        <div class="table" v-for="(user, i) of tableMes" :style="tableHeight" :key="user.id">
            <div v-for="(content) in user.data"
                :style="{ ...content.style, backgroundColor: i % 2 === 0 ? 'rgb(8, 52, 88)' : 'rgb(44, 108, 160)' }"
                :key="content.id">
                <!-- {{ content.type === 'url' ? <img src="'http://localhost:3000'+ content.mes" /> : content.mes }} -->
                <div v-if="content.type === 'url'">
                    <img :src="'http://localhost:3000' + content.mes" alt="" style="max-width: 80px; max-height: 80px;">
                </div>
                <div v-else>{{ content.mes }}</div>
            </div>
            <div class="title"
                :style="{ width: '150px', ...tableHeight, backgroundColor: i % 2 === 0 ? 'rgb(8, 52, 88)' : 'rgb(44, 108, 160)' }">
                <button class="edit" @click="editMes(i)">编辑</button>
                <button class="delete" @click="deleteMes(i)">删除</button>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    name: 'TableMes',
    props: ['tableTitle', 'tableMes', 'tableWidth', 'tableHeight'],
    emits: ['editMes', 'deleteMes'],
    setup(_, context) {
        const editMes = (i) => {
            context.emit('editMes', i);
        }
        const deleteMes = (i) => {
            context.emit('deleteMes', i);
        }
        return {
            editMes,
            deleteMes
        }
    }
}

</script>

<style scoped>
.userTable {
    width: 96%;
    margin: 12px 2% 0 2%;
}

.table {
    color: rgb(253, 149, 30);
    width: 100%;
    height: 50px;
    display: flex;
    background-color: steelblue;
    align-items: center;
    justify-content: center;
}

.table>div {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    border: 1px solid rgb(236, 206, 36);
    border-left: 0;
    border-top: 0;
}

.table>div:nth-child(1) {
    border-left: 1px solid rgb(236, 206, 36);
}

.edit,
.delete {
    border: 0;
    border-radius: 5px;
    margin: 0 5px;
    transition: 200ms;
}

.edit {
    background-color: aquamarine;
}

.edit:hover {
    background-color: rgb(87, 245, 195);

}

.edit:active {
    background-color: rgb(80, 233, 146);
}

.delete {
    background-color: lightpink;
}

.delete:hover {
    background-color: lightsalmon;
}

.delete:active {
    background-color: lightcoral;
}
</style>