import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Game game = Game.getInstance();

    System.out.println("1. Joc Harcodat\n2. Joc Random\n3 Interfata Grafica");
    int index=in.nextInt();
    if(index==3)
    {
      System.out.println(
              """

                            ::::::::   ::::::::    :::   :::   ::::::::::: ::::    :::  ::::::::           ::::::::   ::::::::   ::::::::  ::::    :::           ::: ::: :::\s
                          :+:    :+: :+:    :+:  :+:+: :+:+:      :+:     :+:+:   :+: :+:    :+:         :+:    :+: :+:    :+: :+:    :+: :+:+:   :+:           :+: :+: :+: \s
                         +:+        +:+    +:+ +:+ +:+:+ +:+     +:+     :+:+:+  +:+ +:+                +:+        +:+    +:+ +:+    +:+ :+:+:+  +:+           +:+ +:+ +:+  \s
                        +#+        +#+    +:+ +#+  +:+  +#+     +#+     +#+ +:+ +#+ :#:                +#++:++#++ +#+    +:+ +#+    +:+ +#+ +:+ +#+           +#+ +#+ +#+   \s
                       +#+        +#+    +#+ +#+       +#+     +#+     +#+  +#+#+# +#+   +#+#                +#+ +#+    +#+ +#+    +#+ +#+  +#+#+#           +#+ +#+ +#+    \s
                      #+#    #+# #+#    #+# #+#       #+#     #+#     #+#   #+#+# #+#    #+#         #+#    #+# #+#    #+# #+#    #+# #+#   #+#+#                           \s
                      ########   ########  ###       ### ########### ###    ####  ########           ########   ########   ########  ###    ####           ### ### ###      \s
                      """);
    System.exit(0);
    }
    game.run(index);


  }
}
