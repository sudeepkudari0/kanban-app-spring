export type Task = {
    id: string;
    name: string;
    description: string;
    dueDate: string;
    }

export type Column = {
    id: string;
    name: string;
    tasks: Task[];
}  
  
export type BoardWithID = {
    name: string;
    description: string;
    columns : Column[];
    id: string;
  }
export type Board = {
    name: string;
    description: string;
    column : Column[];
    id: string;
  }  