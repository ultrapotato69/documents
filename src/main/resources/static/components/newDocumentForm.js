import {main, printFirstPage} from "../pages/mainPage.js";
import {postJson} from "../util/ajax.js";

export function createNewDocumentForm() {
    const div = document.createElement('div')
    const caption = document.createElement('span')
    caption.textContent = 'Добавьте новый документ: '
    const buttonName = document.createElement('span')
    const nameInput = document.createElement('input')
    nameInput.type = 'text'
    nameInput.size = 60
    nameInput.placeholder = 'Название документа'
    const submitButton = document.createElement('button')
    submitButton.onclick = () => sendNewAccount(nameInput.value, documentText.value)
    submitButton.innerText = 'Добавить'
    const documentText = document.createElement('textarea')
    documentText.cols = 75
    documentText.rows = 10
    documentText.placeholder = 'Текст документа'
    buttonName.append(nameInput)
    buttonName.append(submitButton)
    div.append(document.createElement('br'))
    div.append(caption)
    div.append(document.createElement("br"))
    div.append(buttonName)
    div.append(document.createElement("br"))
    div.append(documentText)
    main.append(div)
}

async function sendNewAccount(name, text) {
    const account = {
        name,
        text
    }
    await postJson(account, '/documents')
    await printFirstPage()
}