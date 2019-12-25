package com.example.yejoonmanual

import java.util.*
import kotlin.collections.HashMap

object DataManager {

    val juboTasks:Array<String> = arrayOf(
        INST_SHORTCUT, INST_CRED, INST_SERVICE_ORDER, INST_QT,
        INST_FOLDING_MACHINE, INST_PRINT, INST_REVIEW)
    val serviceTasks:Array<String> = arrayOf(INST_YEBEDANG, INST_COMMUNION, INST_SEATING_TIP)

    val keyValueTasks:Set<String> = setOf(INST_SHORTCUT, INST_CRED)
    val keyValueTaskDataMap:TreeMap<String, Map<String, Map<String, String>>> = TreeMap()
    private val shortcutMap = TreeMap<String, Map<String, String>>()
    private val credMap = TreeMap<String, Map<String, String>>()

    val imageTasks:Set<String> = setOf(INST_QT, INST_FOLDING_MACHINE, INST_PRINT,
        INST_YEBEDANG, INST_COMMUNION)
    val imageTaskDataMap: Map<String, Array<Instruction>> = prepareImageTaskDataMap()

    init {
        prepareShortcuts()
        prepareCredentials()
    }

    private fun prepareImageTaskDataMap(): Map<String, Array<Instruction>> {
        return mapOf(
            INST_PRINT to preparePrinterInstructions(),
            INST_FOLDING_MACHINE to prepareFoldingMachineInstructions(),
            INST_QT to prepareQTInstructions())
    }

    private fun preparePrinterInstructions(): Array<Instruction> {
        val paper = Instruction("종이 넣는 방향", "images/printer/printer_paper.jpg", "컬러로 인쇄된 부빈이 \"자신\"쪽으로 오게 종이를 넣어주세요")
        val twoSided = Instruction("양면 프린트", "images/printer/print_two_sided_flip_short_side.jpg", "\"Two-sided, flip short side\"를 선택해야 위 아래가 뒤집히지 않고 양면 프린트를 할 수 있어요")
        val printer = Instruction("Printer Name", "images/printer/printer_name.jpg", "7086 (오른쪽 프린터)\n7095 (왼쪽 프린터")
        return arrayOf(paper, twoSided, printer)
    }

    private fun prepareQTInstructions(): Array<Instruction> {
        val checkFolder = Instruction("예준팀 폴더 확인", null, "예준팀 폴더에서 QT pdf 파일을 열어서 기재하고 pdf 파일이 없으면 밑을 참고하여 예준팀 폴더에 다운받아요")
        val clickMenu = Instruction("duranno.com", "images/qt/qt_menu.png", "메뉴에서 \"큐디\" 클릭")
        val logIn = Instruction("로그인", "images/qt/qt_login.png", "아이디/비번은 앱에 있어요")
        val calendar = Instruction("\"QT 캘린더\" 클릭", "images/qt/qt_calendar_button.png", null)
        val download = Instruction("PDF 파일 다운", "images/qt/qt_download.png", "예준팀 폴더에 넣어주세요. 파일 이름에 연도와 달을 넣어주세요. 예)\"201912\"")
        return arrayOf(checkFolder, clickMenu, logIn, calendar, download)
    }

    private fun prepareFoldingMachineInstructions(): Array<Instruction> {
        val handle = Instruction("핸들 내리기", "images/folding_machine/folding_machine_handle.jpg", "손잡이를 내려 종이를 넣을 공간을 만들어요")
        val paper = Instruction("종이 넣기", "images/folding_machine/folding_machine_paper.jpg", "민들레 포커스가 오른쪽에 놓이도록 종이를 넣고 손잡이를 다시 올려서 종이를 고정시켜 주세요")
        val topScale = Instruction("위에 눈금 조절", "images/folding_machine/folding_machine_top.jpg", "상단 금속 부분의 밑 부분을 빨간선에 맞춰 주세요")
        val bottomScale = Instruction("아래 눈금 조절", "images/folding_machine/folding_machine_bottom.jpg", "오른쪽은 '주보'라고 쓰여진 스티커와 금속에 붙은 화살표를 맞춰주세요. 왼쪽은 빨간선에 맞춰주세요.")
        val testPrint = Instruction("테스트 프린트", "images/folding_machine/folding_machine_button.jpg", "TEST 버튼을 누르면 두 장이 접혀서 나와요. 잘 접혔으면 START 버튼을 눌러서 나머지를 접어주세요")
        val cleanUp = Instruction("정리", "images/folding_machine/folding_machine_cleanup.jpg", "비닐을 덮고 전원을 끄고 전등을 끄고 나오세요")
        return arrayOf(handle, paper, topScale, bottomScale, testPrint, cleanUp)
    }

    private fun prepareCredentials() {
        prepareLaptopCredentials()
        prepareHomePageCredentials()
        prepareEmailCredentials()
        prepareQTCredentials()
        keyValueTaskDataMap.put(INST_CRED, credMap)
    }

    private fun prepareLaptopCredentials() {
        var map = TreeMap<String, String>()
        map.put("비밀번호 (한글)", "찬방팀13")
        map.put("비밀번호 (Eng)", "cksqkdxla13")
        credMap.put("Dell 노트북", map)
    }

    private fun prepareHomePageCredentials() {
        var map = TreeMap<String, String>()
        map.put("ID", "yejoon")
        map.put("비밀번호 (한글)", "예준팀8")
        map.put("비밀번호 (Eng)", "dPwnsxla8")
        credMap.put("홈페이지", map)
    }

    private fun prepareEmailCredentials() {
        var map = TreeMap<String, String>()
        map.put("ID", "youngnakwprep")
        map.put("비밀번호 (한글)", "예준팀8")
        map.put("비밀번호 (Eng)", "dPwnsxla8")
        credMap.put("이메일", map)
    }

    private fun prepareQTCredentials() {
        var map = TreeMap<String, String>()
        map.put("ID", "yntoronto")
        map.put("비밀번호 (한글)", "예준팀8")
        map.put("비밀번호 (Eng)", "dPwnsxla8")
        credMap.put("duranno.com", map)
    }

    private fun prepareShortcuts() {
        prepareTextSelectionShortcuts()
        prepareCopyPasteShortcuts()
        prepareFontShortcuts()
        prepareParagraphShortcuts()
        keyValueTaskDataMap.put(INST_SHORTCUT, shortcutMap)
    }

    private fun prepareTextSelectionShortcuts() {
        val textMap = TreeMap<String, String>()
        textMap.put("전체 선택", "Ctrl + A")
        textMap.put("저장", "Ctrl + S")
        textMap.put("키보드로 텍스트 선택", "Shift + 방향키 / Home / End")
        textMap.put("광고 댓글 전체 선택", "마우스 세 번 클릭")
        textMap.put("전체 선택", "Ctrl + A")
        textMap.put("전체 선택", "Ctrl + A")
        shortcutMap.put("텍스트 선택", textMap)
    }

    private fun prepareCopyPasteShortcuts() {
        val copyPasteMap = TreeMap<String, String>()
        copyPasteMap.put("복사", "Ctrl + C")
        copyPasteMap.put("붙이기", "Ctrl + V")
        copyPasteMap.put("Paste Special\nUnformatted Text", "Ctrl + Alt + V")
        shortcutMap.put("복사 & 붙이기", copyPasteMap)
    }

    private fun prepareFontShortcuts() {
        val fontMap = TreeMap<String, String>()
        fontMap.put("Bold", "Ctrl + B")
        fontMap.put("Underline", "Ctrl + U")
        shortcutMap.put("폰트", fontMap)
    }

    private fun prepareParagraphShortcuts() {
        val paragraphMap = TreeMap<String, String>()
        paragraphMap.put("양쪽 맞춤 (Justify)", "Ctrl + J")
        shortcutMap.put("문단 정렬", paragraphMap)
    }

}