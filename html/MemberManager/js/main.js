let index = 0;

document.addEventListener('DOMContentLoaded', () => {
    const submit = document.querySelector('#apply');
    const listView = document.querySelector('#apply-list');

    submit.addEventListener('click', (event) => {
        let idInput = document.querySelector('#id');
        let pwInput = document.querySelector('#pw');
        let pw2Input = document.querySelector('#pw2');
        let nameInput = document.querySelector('#name');
        if(idInput.value.trim() == '') {
            alertBlankMessage(idInput, 'id');
            return;
        }
        if(pwInput.value.trim() == '') {
            alertBlankMessage(pwInput, '비밀번호');
            return;
        }
        if(nameInput.value.trim() == '') {
            alertBlankMessage(nameInput, '이름');
            return;
        }

        if(pwInput.value.trim() != pw2Input.value.trim()) {
            alert('비밀번호가 다릅니다. 다시 확인해주세요.');
            pw2Input.value = "";
            pw2Input.focus();
            return;
        }

        let tr = document.createElement(`tr`);
        tr.setAttribute('id', index);
        tr.innerHTML = `<td>${index}</td>
        <td>${idInput.value}</td>
        <td>${pwInput.value}</td>
        <td>${nameInput.value}</td>
        <td>
            <input type=button class="button remove" id="list-${index}" value="remove">
        </td>`;


        listView.append(tr);

        let removeBtn = document.querySelector(`#list-${index++}`);
        removeBtn.addEventListener('click', (event) => {
            tr.remove();
        });

        idInput.value = '';
        pwInput.value = '';
        pw2Input.value = '';
        nameInput.value = '';
        idInput.focus();
    });
});

function alertBlankMessage(cursor, str) {
    alert(`${str}(은)는 비워둘 수 없습니다.`);
    cursor.focus();
}