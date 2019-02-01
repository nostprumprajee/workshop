<template>
  <div class="con-center">
    <h1>05.-v-if,v-show</h1>
    <br><br>
    <h1 v-if="ok">Hello {{ name }}</h1>
    <h2 v-show="ok">UP NAME - {{ upperName }}</h2>
    <br><br>
    <input type="text" :value="name"/>
    <br><br>
    <input type="text" v-model="name"/>
    <br><br>
    <button @click="doSave">Save</button>
  </div>
</template>

<script>
export default {
  data() {
      
    return {
      name: "Nost",
      ok: true
    };
  },
  computed: {
  upperName() {
    return this.name.toUpperCase()
  }
},
    methods: {
        doSave(){
            this.ok = !this.ok;
            console.log("This is name: "+this.name);
        }
    }
};
</script>

<style>
.con-center {
  text-align: center;
  margin-top: 1rem;
}
</style>