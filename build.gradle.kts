
import myaa.subkt.ass.*
import myaa.subkt.tasks.*
import myaa.subkt.tasks.Mux.*
import myaa.subkt.tasks.Nyaa.*
import java.awt.Color
import java.time.*

plugins {
    id("myaa.subkt")
}

subs {
    readProperties("sub.properties")
    episodes(getList("episodes"))

    mux {
        title(get("title"))

        from(get("raws")) {
            video {
                name("")
                lang("jpn")
                default(true)
            }
            audio {
                name("FLAC 2.0")
                lang("jpn")
                default(true)
            }
            subtitles {
                include(false)
            }
            attachments {
                include(false)
            }
        }

        from(get("subs")) {
            tracks {
                name(get("group"))
                lang("vie")
                default(true)
            }
        }

        attach(get("fonts")) {
            includeExtensions("ttf", "otf")
        }
        skipUnusedFonts(true)
        verifyFonts(false)
        onMissingFonts(ErrorMode.IGNORE)
        out(get("muxout"))
    }
}
