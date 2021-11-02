import {main, right} from "../pages/mainPage.js";
import {getJsonFromAddress} from "../util/ajax.js";
import {clearElement} from "../util/util.js";
import {getDocumentCodes,getDocumentName, getDocumentNumber, getDocumentSaveTime, getDocumentText } from "./documentElements.js";


const mainList = document.createElement('div')

export async function initialListElement() {
    main.append(mainList)
    await addListElements();
}

let filterCache = null;
let codeCache = null;

async function addListElements(pageNumber, filter, code) {
    clearElement(mainList)
    let url = "/documents"
    if (pageNumber !== undefined && pageNumber !== null) {
        url = url + "?page=" + pageNumber
        if (filterCache !== null & codeCache !== null) {
            url = url + "&filter=" + filterCache + "&code=" + codeCache
        }
    }
    if (filter !== undefined && code !== undefined && filter !== null && code !== null) {
        if (pageNumber !== undefined && pageNumber !== null) {
            url = url + "&"
        } else {
            url = url + "?"
        }
        url = url + "filter=" + filter + "&code=" + code
    }
    const page = await getJsonFromAddress(url)
    const pagination = navBar(page)
    const list = await createList(page)
    mainList.append(pagination)
    mainList.append(list)
}

function navBar(page) {

    const nav = document.createElement('nav')
    const paginationBar = document.createElement('ul')
    paginationBar.id = "menu-horiz"
    const b = document.createElement('b')
    b.innerText = "Страницы: "
    paginationBar.append(b)
    for (let i = 0; i < page.totalPages; i++) {
        const li = document.createElement('li')
        const button = document.createElement('button')
        button.innerText = i + 1
        button.onclick = () => addListElements(i + 1)
        if (i === page.number) {
            button.style.background = "#a9a9a9";
        }
        li.append(button)
        paginationBar.append(li)
    }
    const span = document.createElement('span')
    span.innerText = 'из ' + page.totalPages + ' страниц'
    paginationBar.append(span)

    const filter = document.createElement('span')
    const label = document.createElement('b')
    label.innerText = 'Фильтровать по кодам: '
    const codeInput = document.createElement('input')
    codeInput.type = 'text'
    codeInput.size = 10
    const lessButton = document.createElement('button')
    lessButton.innerText = "Меньше"
    lessButton.onclick = () =>  {
        filterCache = "less"
        codeCache = codeInput.value
        addListElements(null,"less", codeInput.value)
    }
    const equalsButton = document.createElement('button')
    equalsButton.innerText = "Равно"
    equalsButton.onclick = () => {
        filterCache = "equals"
        codeCache = codeInput.value
        addListElements(null,"equals", codeInput.value)
    }
    const greaterButton = document.createElement('button')
    greaterButton.innerText = "Больше"
    greaterButton.onclick = () => {
        filterCache = "greater"
        codeCache = codeInput.value
        addListElements(null,"greater", codeInput.value)
    }
    filter.append(label)
    filter.append(codeInput)
    filter.append(lessButton)
    filter.append(equalsButton)
    filter.append(greaterButton)
    nav.append(paginationBar)
    nav.append(filter)
    return nav
}

export async function createList(page) {
    const list = document.createElement('div')
    for (let i = 0; i < page.content.length; i++) {
        const row = document.createElement('div')
        const num = getDocumentNumber(page.content[i].id);
        const name = getDocumentName(page.content[i].name);
        const saveTime = getDocumentSaveTime(page.content[i].saveTime)
        const codesEl = getDocumentCodes(page.content[i].codes)
        const linkButton = document.createElement('button')
        linkButton.innerText = "Просмотреть"
        linkButton.onclick = async() => getDocument(page.content[i].id)
        row.append(document.createElement("br"))
        row.append(num)
        row.append(name)
        row.append(saveTime)
        row.append(codesEl)
        row.append(linkButton)
        list.append(row)
    }
    return list
}

async function getDocument(id) {
        let result = await getJsonFromAddress('/documents/' + id)
        return createAccountPage(result)
}

async function createAccountPage(documentObj) {
    clearElement(right)
    const documentEl = document.createElement('div')
    const num = getDocumentNumber(documentObj.id);
    const name = getDocumentName(documentObj.name);
    const saveTime = getDocumentSaveTime(documentObj.saveTime)
    const codes = getDocumentCodes(documentObj.codes)
    const text = getDocumentText(documentObj.text)
    documentEl.append(num)
    documentEl.append(name)
    documentEl.append(saveTime)
    documentEl.append(codes)
    documentEl.append(text)
    right.append(documentEl)
}