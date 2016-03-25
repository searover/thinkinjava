@RestController
class ThisWillActualRun {
    
    @RequestMapping("/")
    String home(){
        return "Hello World!"
    }
}
