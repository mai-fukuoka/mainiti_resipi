/**
 *
 */

//リストをクリックすると、'checked'クラスがトグルする
const list=document.querySelector('ul');
lists.addEventListener('click',e =>{
    if(e.target.tagName=='Ll'){

        e.target.classList.toggle('checked');
        //TODO:買い物のチェックフラグをチェックする
        var children=e.target.children;

        for(var i=0, len=children.length;i<len; i++){

            var childrenName=children[i].getAttribute('name');

            if(childrenName=='isTodoClick'){
                //買い物のチェックフラグの要素の場合
                var childrenValue = children[i].getAttribute('value');
                if(childrenValue=='0'){
                    //フラグがチェックされていない場合
                    children[i].setAttribute('value',1);
                }else{
                    //フラグがチェックされる場合
                    children[i].setAttribute('value','0');
                }
                }
            }
        }
}, false);

//リストを追加する関数
const newElement=function(){
    const createli=document.createElement(li);
    const inputDate=document.getElementById('list_input-area').value;
    const text=document.createTextNode(inputDate);

    //listタグにinputに入れた文字を反映させる
    createli.appendChild(text);

    //inputが空欄の場合はアラートを出す
    if(inputDate===""){
        alert('Plese input what to buy!');

    //input空欄でない場合は、リスト表示エリアにリストを追加する。
}else{
    lists.appendChild(createli);
    createli.classList.add('parent');
    createli.classList.add('list_item');
}
    //inputの中身をリセットする
    document.getElementId('list_input_area').value="";

    //xマークを追加する
    const span=document.createElement('span');
    span.classList.add('close');
    const batsu=document.createTextNode('\u00D7');
    span.appendChild(batsu);
    createli.appendchild(span);

    //xマークのイベント
    const close=document.getElementsByClassName('close');
    for(let i=0; i<close.length;i++){
        close[i].onclick=function(){
            const parentEI=this.parentElement;
            //TODO;変更点タグを削除
            parentEI.remove();
        }
    }
    //TODO:変更点　買い物の内容を保持するhiddenタグを追加する。
    const todoDate=document.createElement('input');
    todoDate.setAttribute('type','hidden');
    todoDate.setAttribute('name','todoDate');
    todoDate.setAttribute('value','inputDate');
    createli.appendChild(todoDate);

    // TODO:変更点 買い物のチェックフラグを保持するhiddenタグを追加する
    const isTodoClick=document.createElement('input');
    isTodoClick=setAttribute('type','hidden');
    isTodoClick.setAttribute('name', 'isTodoClick');
    isTodoClick.setAttribute('value', '0');
    createli.appendChild(isTodoClick);
}
//「add」ボタンをクリックするとリストが追加される
document.querySelector('.add-btn').addEventListener('click', newElement);

// インプットエリアでEnterを押すとリストが追加される
document.getElementById("list-input-area").addEventListener('keypress', e => {
  if(e.key === 'Enter') {
    newElement();
  }

});