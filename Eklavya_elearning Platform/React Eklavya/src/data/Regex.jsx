export const validEmail = new RegExp(
  "^[a-zA-Z0-9._:$!%-]+@[a-zA-Z0-9.-]+.[a-zA-Z]$"
);
export const validUserName=new RegExp("^[A-Za-z_#@0-9]{6,10}$")
export const validPassword = new RegExp("^[0-9]{1,6}$");

export const onlyChar = new RegExp("^[A-Za-z]+$");

export const onlyPhone = new RegExp("^[0-9]{10}$");
