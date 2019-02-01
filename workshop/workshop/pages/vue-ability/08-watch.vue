<template>
    <div class="con-center">
        <h1>08. Watch</h1>
        <br><hr>
        <h1>Hello {{ name }}</h1>
        <br>
        <input type="text" v-model="name"/>
        <br><br>
        <button @click="doSave">Save</button>
        <br>
        <br>
        <ul>
            <li v-for="(uname,index) in namelists" :key="index">
                {{ uname }}
            </li>
        </ul>
    </div>
</template>

<script>
export default {
  data() {
    return {
      name: "",
      namelists: ["Art"]
    };
  },
  watch: {
    namelists() {
      if (this.namelists.length > 4) {
        alert("Length : " + this.namelists.length);
      }
    }
  },
  methods: {
    doSave() {
      this.namelists.push(this.name);
      this.name = "";
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