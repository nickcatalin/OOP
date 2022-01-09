import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Game game = Game.getInstance();

    System.out.println("1. Joc Harcodat\n2. Joc Random\n3 Interfata Grafica");
    int index=in.nextInt();
    if(index==3)
    {
      System.out.println(
          "\n"
              + "      ::::::::   ::::::::    :::   :::   ::::::::::: ::::    :::  ::::::::           ::::::::   ::::::::   ::::::::  ::::    :::           ::: ::: ::: \n"
              + "    :+:    :+: :+:    :+:  :+:+: :+:+:      :+:     :+:+:   :+: :+:    :+:         :+:    :+: :+:    :+: :+:    :+: :+:+:   :+:           :+: :+: :+:  \n"
              + "   +:+        +:+    +:+ +:+ +:+:+ +:+     +:+     :+:+:+  +:+ +:+                +:+        +:+    +:+ +:+    +:+ :+:+:+  +:+           +:+ +:+ +:+   \n"
              + "  +#+        +#+    +:+ +#+  +:+  +#+     +#+     +#+ +:+ +#+ :#:                +#++:++#++ +#+    +:+ +#+    +:+ +#+ +:+ +#+           +#+ +#+ +#+    \n"
              + " +#+        +#+    +#+ +#+       +#+     +#+     +#+  +#+#+# +#+   +#+#                +#+ +#+    +#+ +#+    +#+ +#+  +#+#+#           +#+ +#+ +#+     \n"
              + "#+#    #+# #+#    #+# #+#       #+#     #+#     #+#   #+#+# #+#    #+#         #+#    #+# #+#    #+# #+#    #+# #+#   #+#+#                            \n"
              + "########   ########  ###       ### ########### ###    ####  ########           ########   ########   ########  ###    ####           ### ### ###       \n");
    System.exit(0);
    }
    game.run(index);


  }
}
