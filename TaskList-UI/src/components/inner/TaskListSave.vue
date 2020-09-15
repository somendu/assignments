<template>
  <div id="editor-content" class="mt-2">
    <table class="mt-2" border="1" width="100%">
      <tr>
        <td>
          <p>Date</p>
          <datepicker
            placeholder="Select Date"
            size="40"
            v-model="value.taskDate"
            format="dd-MM-yyyy"
            name="taskDate"
          ></datepicker>
        </td>

        <td>
          <p>Task</p>
          <input id="task-input" type="text" size="40" v-model="value.taskList" />
        </td>

        <td>
          <p>Name</p>
          <input id="name-input" type="text" size="40" v-model="value.consName" />
        </td>
      </tr>
      <!-- TODO Add PLus Button here to save multiple line -->
    </table>
    <br />
    <br />
    <div id="task-save">
      <input id="save-button" type="Button" value="Add Task" v-on:click="saveData()" />
      &nbsp;&nbsp;&nbsp;
      <input id="cancel-button" type="Button" value="Cancel Task" />
    </div>
  </div>
</template>

<script>
  import Datepicker from "vuejs-datepicker/dist/vuejs-datepicker.esm.js";

  function pad2(num) {
    if (num < 10) return "0" + num;
    return num;
  }

  function formatDate(value) {
    return pad2(
      value.getDate() +
        "-" +
        pad2(value.getMonth() + 1) +
        "-" +
        value.getFullYear()
    );
  }

  function parseDate(value) {
    if (typeof value === "string" && value.length === 10) {
      const day = parseInt(value.substring(0, 1), 10);
      const month = parseInt(value.substring(3, 5), 10);
      const year = parseInt(value.substring(7), 10);

      if (!isNaN(year) && !isNaN(month) && !isNaN(day)) {
        return new Date(day, month - 1, year);
      }
    }

    return null;
  }

  export default {
    name: "TaskListSave",

    components: {
      Datepicker
    },

    data() {
      return {
        value: {
          taskDate: new Date(),
          taskList: "",
          consName: ""
        },

        error: ""
      };
    },

    methods: {
      set(value) {
        value.taskDate = parseDate(value.taskDate);
        this.$set(this, "value", value);
      },

      saveData() {
        const result = {};

        for (let key of Object.keys(this.value)) {
          if (this.value[key] != null && this.value[key] !== "") {
            result[key] = this.value[key];
          }
        }

        this.value.taskDate = formatDate(result.taskDate);

        fetch("/api/insertTaskList", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            taskDate: this.value.taskDate,
            taskList: this.value.taskList,
            consName: this.value.consName
          })
        })
          .then(this.fetchResponseHandler)
          .then(res => {
            console.log("Response : " + res.insertSuccess);
          }) //TODO Use this response to show notification
          .catch(error => {
            this.error = error;
            console.error("There was an error!", error);
          });

        window.location.reload();
      },

      fetchResponseHandler(res) {
        if (!res.ok) {
          return res.text().then(text => {
            const error = new Error(`HTTP Status ${res.status}`);
            try {
              const json = JSON.parse(text);
              Object.assign(error, json);
            } catch (ex) {
              // ignore
              error.responseText = text;
            }
            throw error;
          });
        }
        return res.json();
      }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h3 {
    margin: 40px 0 0;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
  .tab-button {
    padding: 6px 10px;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
    border: 1px solid #ccc;
    cursor: pointer;
    background: #f0f0f0;
    margin-bottom: -1px;
    margin-right: -1px;
  }
  .tab-button:hover {
    background: #e0e0e0;
  }
  .tab-button.active {
    background: #e0e0e0;
  }
  .tab {
    border: 1px solid #ccc;
    padding: 10px;
  }

  .editor-column {
    max-height: 95%;
    overflow-y: auto;
  }

  .editor-content {
    display: flex;
    flex-direction: row;
  }

  .material-icons {
    font-family: "Material Icons";
    font-weight: normal;
    font-style: normal;
    font-size: 24px; /* Preferred icon size */
    display: inline-block;
    line-height: 1;
    text-transform: none;
    letter-spacing: normal;
    word-wrap: normal;
    white-space: nowrap;
    direction: ltr;

    /* Support for all WebKit browsers. */
    -webkit-font-smoothing: antialiased;
    /* Support for Safari and Chrome. */
    text-rendering: optimizeLegibility;

    /* Support for Firefox. */
    -moz-osx-font-smoothing: grayscale;

    /* Support for IE. */
    font-feature-settings: "liga";
  }
</style>
