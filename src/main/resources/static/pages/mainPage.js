import {clearElement} from "../util/util.js";
import {createNewDocumentForm} from "../components/newDocumentForm.js";
import {createList, initialListElement} from "../components/paginationList.js";


export const main = document.getElementById('main');
export const right = document.getElementById('right');

(async () => { await printFirstPage() })()

export async function printFirstPage() {
    clearElement(main)
    createNewDocumentForm()
    await initialListElement()
}